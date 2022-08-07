package com.mertkalecik.infinitescrollview.base

interface UseCase<INPUT, OUTPUT> {
    suspend fun run(input: INPUT): OUTPUT
}