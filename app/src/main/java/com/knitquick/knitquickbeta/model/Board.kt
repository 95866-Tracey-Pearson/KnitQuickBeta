package com.knitquick.knitquickbeta.model

import android.os.Parcel
import android.os.Parcelable


// TODO (Step 1: Create a Board Model which will we use for creating the board.)
// START
data class Board(
    val name: String = "",
    val image: String = "",
    val createdBy: String = "",
    val assignedTo: ArrayList<String> = ArrayList()
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString()!!,
        source.readString()!!,
        source.readString()!!,
        source.createStringArrayList()!!
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeString(image)
        writeString(createdBy)
        writeStringList(assignedTo)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Board> = object : Parcelable.Creator<Board> {
            override fun createFromParcel(source: Parcel): Board = Board(source)
            override fun newArray(size: Int): Array<Board?> = arrayOfNulls(size)
        }
    }
}
// END