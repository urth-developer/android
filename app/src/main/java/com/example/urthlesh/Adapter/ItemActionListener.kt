package com.example.urthlesh.Adapter

interface ItemActionListener {
    fun onItemMoved(from:Int ,to :Int)
    fun onItemSwiped(position:Int)
}