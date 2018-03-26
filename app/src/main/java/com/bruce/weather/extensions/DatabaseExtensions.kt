package com.bruce.weather.extensions

import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.SelectQueryBuilder

/**
 * Created by Bruce on 2018/3/26.
 */
fun <T: Any> SelectQueryBuilder.parseList(parser: (Map<String, Any?>) -> T): List<T> = parseList( object : MapRowParser<T> {
    override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
})

fun <T: Any> SelectQueryBuilder.parseOpt(parser: (Map<String, Any?>) -> T): T? = parseOpt(object : MapRowParser<T> {
    override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
})

fun SQLiteDatabase.clear(tableName: String) {
    execSQL("delete form $tableName")
}

fun SelectQueryBuilder.byId(id: Long) = whereSimple("_id=?", id.toString())
