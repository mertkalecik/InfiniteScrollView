package com.github.mertkalecik.sample.base

interface UseCase<INPUT, OUTPUT> {
    suspend fun run(input: INPUT): OUTPUT
}