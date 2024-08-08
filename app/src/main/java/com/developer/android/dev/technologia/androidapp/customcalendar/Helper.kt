package com.developer.android.dev.technologia.androidapp.customcalendar

import android.content.Context

fun getMonth(month:Int,context:Context):String?{
    when(month){
        1->return context.resources.getString(R.string.jan)
        2->return context.resources.getString(R.string.feb)
        3->return context.resources.getString(R.string.mar)
        4->return context.resources.getString(R.string.april)
        5->return context.resources.getString(R.string.may)
        6->return context.resources.getString(R.string.june)
        7->return context.resources.getString(R.string.july)
        8->return context.resources.getString(R.string.aug)
        9->return context.resources.getString(R.string.sep)
        10->return context.resources.getString(R.string.oct)
        11->return context.resources.getString(R.string.nov)
        12->return context.resources.getString(R.string.dec)
    }
    return  null
}