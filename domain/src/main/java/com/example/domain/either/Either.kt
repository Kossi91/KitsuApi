package com.example.domain.either

/**
 * [Either] Either - это класс-обертка, который содержит либо Left значение, либо Right значение.
 * Используется для обработки ситуаций, когда есть два возможных результата выполнения операции.
 * Left тип используется для ошибок, а Right - для успешных результатов.
 */
sealed class Either<out A, out B> {
    class Left<out A>(val value: A) : Either<A, Nothing>()
    class Right<out B>(val value: B) : Either<Nothing, B>()
}