package com.example.urthlesh

import android.content.Context
import android.graphics.Point
import android.os.Build
import android.support.annotation.Dimension
import android.support.annotation.IntDef
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup




/**
 * An extension of [LinearLayoutManager], where each list item can be offset along a circular
 * trajectory.
 */
class TurnLayoutManager
/**
 * Define a new [TurnLayoutManager] with the given settings.<br></br>
 * `gravity` and `orientation` combine to define the curvature of the turn:
 * <br></br><br></br>
 * [Gravity.START]<br></br>
 * [Orientation.VERTICAL]
 * <pre>
 * ┏─────────┓
 * ┃ x       ┃
 * ┃  x      ┃
 * ┃   x     ┃
 * ┃   x     ┃
 * ┃   x     ┃
 * ┃  x      ┃
 * ┃ x       ┃
 * ┗─────────┛
</pre> *
 * <br></br>
 * [Gravity.END]<br></br>
 * [Orientation.VERTICAL]
 * <pre>
 * ┏─────────┓
 * ┃       x ┃
 * ┃      x  ┃
 * ┃     x   ┃
 * ┃     x   ┃
 * ┃     x   ┃
 * ┃      x  ┃
 * ┃       x ┃
 * ┗─────────┛
</pre> *
 *
 *
 * <br></br>
 * [Gravity.START]<br></br>
 * [Orientation.HORIZONTAL]
 * <pre>
 * ┏─────────┓
 * ┃x       x┃
 * ┃ x     x ┃
 * ┃   xxx   ┃
 * ┃         ┃
 * ┃         ┃
 * ┃         ┃
 * ┃         ┃
 * ┗─────────┛
</pre> *
 *
 *
 * <br></br>
 * [Gravity.END]<br></br>
 * [Orientation.HORIZONTAL]
 * <pre>
 * ┏─────────┓
 * ┃         ┃
 * ┃         ┃
 * ┃         ┃
 * ┃         ┃
 * ┃   xxx   ┃
 * ┃ x     x ┃
 * ┃x       x┃
 * ┗─────────┛
</pre> *
 *
 * @param gravity      The [Gravity] that will define where the anchor point is for this layout manager.  The
 * gravity point is the point around which items orbit.
 * @param orientation  The orientation as defined in [LinearLayoutManager], and enforced by [Orientation]
 * @param radius       The radius of the rotation angle, which helps define the curvature of the turn.  This value
 * will be clamped to `[0, MAX_INT]` inclusive.
 * @param peekDistance The absolute extra distance from the [Gravity] edge after which this layout manager will start
 * placing items.  This value will be clamped to `[0, radius]` inclusive.
 * @param rotate       Should the items rotate as if on a turning surface, or should they maintain
 * their angle with respect to the screen as they orbit the center point?
 */
    (
    context: Context,
    @param:Gravity @field:Gravity
    private var gravity: Int,
    @Orientation orientation: Int,
    @Dimension radius: Int,
    @Dimension peekDistance: Int,
    private var rotate: Boolean
) : LinearLayoutManager(context, orientation, false) {
    @Dimension
    private var radius: Int = 0
    @Dimension
    private var peekDistance: Int = 0
    private var center: Point? = null


    /**
     * Valid gravity settings for a [TurnLayoutManager].  This defines the direction of the center point
     * around which items will rotate.
     */
    @IntDef(value = [Gravity.START, Gravity.END])
    annotation class Gravity {
        companion object {
            const val START = android.view.Gravity.START
           const  val END = android.view.Gravity.END
        }
    }

    /**
     * Orientation as defined in [LinearLayoutManager]
     */
    @IntDef(value = [Orientation.VERTICAL, Orientation.HORIZONTAL])
    annotation class Orientation {
        companion object {
            const val VERTICAL = LinearLayoutManager.VERTICAL
           const val HORIZONTAL = LinearLayoutManager.HORIZONTAL
        }
    }

    init {
        this.radius = Math.max(radius, MIN_RADIUS)
        this.peekDistance = Math.min(Math.max(peekDistance, MIN_PEEK), radius)
        this.center = Point()
    }

    /**
     * Create a [TurnLayoutManager] with default settings for gravity, orientation, and rotation.
     */
    constructor(
        context: Context,
        @Dimension radius: Int,
        @Dimension peekDistance: Int
    ) : this(context, Gravity.START, Orientation.VERTICAL, radius, peekDistance, false) {
    }

    fun setRadius(radius: Int) {
        this.radius = Math.max(radius, MIN_RADIUS)
        requestLayout()
    }

    fun setPeekDistance(peekDistance: Int) {
        this.peekDistance = Math.min(Math.max(peekDistance, MIN_PEEK), radius)
        requestLayout()
    }

    fun setGravity(@Gravity gravity: Int) {
        this.gravity = gravity
        requestLayout()
    }

    fun setRotate(rotate: Boolean) {
        this.rotate = rotate
        requestLayout()
    }

    override fun scrollVerticallyBy(dy: Int, recycler: RecyclerView.Recycler?, state: RecyclerView.State?): Int {
        val by = super.scrollVerticallyBy(dy, recycler, state)
        setChildOffsetsVertical(gravity, radius, center, peekDistance)
        return by
    }

    override fun scrollHorizontallyBy(dx: Int, recycler: RecyclerView.Recycler?, state: RecyclerView.State?): Int {
        val by = super.scrollHorizontallyBy(dx, recycler, state)
        setChildOffsetsHorizontal(gravity, radius, center, peekDistance)
        return by
    }

    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State) {
        super.onLayoutChildren(recycler, state)
        this.center = deriveCenter(gravity, orientation, radius, peekDistance, center)
        setChildOffsets(gravity, orientation, radius, center, peekDistance)
    }

    /**
     * Accounting for the settings of [Gravity] and [Orientation], find the center point
     * around which this layout manager should arrange list items.  Place the resulting coordinates
     * into `out`, to avoid reallocation.
     */
    private fun deriveCenter(
        @Gravity gravity: Int,
        orientation: Int,
        @Dimension radius: Int,
        @Dimension peekDistance: Int,
        out: Point?
    ): Point {
        val gravitySign = if (gravity == Gravity.START) -1 else 1
        val distanceMultiplier = if (gravity == Gravity.START) 0 else 1
        val x: Int
        val y: Int
        when (orientation) {
            Orientation.HORIZONTAL -> {
                y = distanceMultiplier * height + gravitySign * Math.abs(radius - peekDistance)
                x = width / 2
            }
            Orientation.VERTICAL -> {
                y = height / 2
                x = distanceMultiplier * width + gravitySign * Math.abs(radius - peekDistance)
            }
            else -> {
                y = height / 2
                x = distanceMultiplier * width + gravitySign * Math.abs(radius - peekDistance)
            }
        }
        out!!.set(x, y)
        return out
    }

    /**
     * Find the absolute horizontal distance by which a view at `viewY` should offset
     * to align with the circle `center` with `radius`, accounting for `peekDistance`.
     */
    private fun resolveOffsetX(radius: Double, viewY: Double, center: Point, peekDistance: Int): Double {
        val opposite = Math.abs(center.y - viewY)
        val radiusSquared = radius * radius
        val oppositeSquared = opposite * opposite
        val adjacentSideLength = Math.sqrt(radiusSquared - oppositeSquared)
        return adjacentSideLength - radius + peekDistance
    }

    /**
     * Find the absolute vertical distance by which a view at `viewX` should offset to
     * align with the circle `center` with {@ode radius}, account for `peekDistance`.
     */
    private fun resolveOffsetY(radius: Double, viewX: Double, center: Point, peekDistance: Int): Double {
        val adjacent = Math.abs(center.x - viewX)
        val radiusSquared = radius * radius
        val adjacentSquared = adjacent * adjacent
        val oppositeSideLength = Math.sqrt(radiusSquared - adjacentSquared)
        return oppositeSideLength - radius + peekDistance
    }

    /**
     * Traffic method to divert calls based on [Orientation].
     *
     * @see .setChildOffsetsVertical
     * @see .setChildOffsetsHorizontal
     */
    private fun setChildOffsets(
        @Gravity gravity: Int,
        orientation: Int,
        @Dimension radius: Int,
        center: Point?,
        peekDistance: Int
    ) {
        if (orientation == LinearLayoutManager.VERTICAL) {
            setChildOffsetsVertical(gravity, radius, center, peekDistance)
        } else if (orientation == LinearLayoutManager.HORIZONTAL) {
            setChildOffsetsHorizontal(gravity, radius, center, peekDistance)
        }
    }

    /**
     * Set the bumper offsets on child views for [Orientation.VERTICAL]
     */
    private fun setChildOffsetsVertical(
        @Gravity gravity: Int,
        @Dimension radius: Int,
        center: Point?,
        peekDistance: Int
    ) {
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            val layoutParams = child!!.layoutParams as RecyclerView.LayoutParams
            val xOffset = resolveOffsetX(
                radius.toDouble(),
                (child.y + child.height / 2).toDouble(),
                center!!,
                peekDistance
            ).toInt()
            val x = if (gravity == Gravity.START)
                xOffset + getMarginStart(layoutParams)
            else
                width - xOffset - child.width - getMarginStart(layoutParams)
            child.layout(x, child.top, child.width + x, child.bottom)
            setChildRotationVertical(gravity, child, radius, center)
        }
    }

    /**
     * Given that the is [Orientation.VERTICAL], apply rotation if rotation is enabled.
     */
    private fun setChildRotationVertical(@Gravity gravity: Int, child: View, radius: Int, center: Point) {
        if (!rotate) {
            child.rotation = 0f
            return
        }
        val childPastCenter = child.y + child.height / 2 > center.y
        val directionMult: Float
        if (gravity == Gravity.END) {
            directionMult = (if (childPastCenter) -1 else 1).toFloat()
        } else {
            directionMult = (if (childPastCenter) 1 else -1).toFloat()
        }
        val opposite = Math.abs(child.y + child.height / 2 - center.y)
        child.rotation = (directionMult * Math.toDegrees(Math.asin((opposite / radius).toDouble()))).toFloat()
    }

    /**
     * Set bumper offsets on child views for [Orientation.HORIZONTAL]
     */
    private fun setChildOffsetsHorizontal(
        @Gravity gravity: Int,
        @Dimension radius: Int,
        center: Point?,
        peekDistance: Int
    ) {
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            val layoutParams = child!!.layoutParams as RecyclerView.LayoutParams
            val yOffset = resolveOffsetY(
                radius.toDouble(),
                (child.x + child.width / 2).toDouble(),
                center!!,
                peekDistance
            ).toInt()
            val y = if (gravity == Gravity.START)
                yOffset + getMarginStart(layoutParams)
            else
                height - yOffset - child.height - getMarginStart(layoutParams)

            child.layout(child.left, y, child.right, child.height + y)
            setChildRotationHorizontal(gravity, child, radius, center)
        }
    }

    /**
     * Given that the orientation is [Orientation.HORIZONTAL], apply rotation if enabled.
     */
    private fun setChildRotationHorizontal(@Gravity gravity: Int, child: View, radius: Int, center: Point) {
        if (!rotate) {
            child.rotation = 0f
            return
        }
        val childPastCenter = child.x + child.width / 2 > center.x
        val directionMult: Float
        if (gravity == Gravity.END) {
            directionMult = (if (childPastCenter) 1 else -1).toFloat()
        } else {
            directionMult = (if (childPastCenter) -1 else 1).toFloat()
        }
        val opposite = Math.abs(child.x + child.width / 2 - center.x)
        child.rotation = (directionMult * Math.toDegrees(Math.asin((opposite / radius).toDouble()))).toFloat()
    }

    /**
     * @see android.view.ViewGroup.MarginLayoutParams.getMarginStart
     */
    private fun getMarginStart(layoutParams: ViewGroup.MarginLayoutParams): Int {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            layoutParams.marginStart
        } else layoutParams.leftMargin
    }

    companion object {

        private val MIN_RADIUS = 0
        private val MIN_PEEK = 0
    }


}
