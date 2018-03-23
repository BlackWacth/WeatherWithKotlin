package com.bruce.weather.domain.commands

/**
 * Created by Bruce on 2018/3/21.
 */
public interface Command<T> {
    fun execute(): T
}