package com.example.crudphp

import java.io.Serializable

data class NoteModel (
val notes: List<Data>
){
    data class Data(val id:String?,val note:String?) : Serializable
}
