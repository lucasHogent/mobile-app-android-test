package com.project.beertracker.domain.usecases

interface SuspendUseCase<Input, Output> {
    suspend fun execute(input: Input): Output
}

interface UseCase<Input, Output> {
    fun execute(input: Input): Output
}