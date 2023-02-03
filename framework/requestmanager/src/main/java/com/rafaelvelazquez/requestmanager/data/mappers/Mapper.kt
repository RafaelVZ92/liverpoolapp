package com.rafaelvelazquez.requestmanager.data.mappers

interface Mapper<I, O> {

    fun map(input: I): O
}