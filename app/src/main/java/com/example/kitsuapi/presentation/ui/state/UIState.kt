package com.example.kitsuapi.presentation.ui.state
/**
 * [UIState] Класс, описывающий состояние пользовательского интерфейса.
 * T - тип данных, связанных с состоянием интерфейса.
 */
sealed class UIState<T> {
    /**
     * [Idle] Idle - класс, представляющий состояние, когда пользовательский
     * интерфейс находится в неактивном состоянии.
     */
    class Idle<T>: UIState<T>()
    /**
     * [Loading] Loading - класс, представляющий состояние загрузки.
     */
    class Loading<T> : UIState<T>()
    /**
     * [Error] Error - класс, представляющий состояние ошибки.
     */
    class Error<T>(val error: String) : UIState<T>()
    /**
     * [Success] Success - класс, представляющий состояние успешного выполнения.
     */
    class Success<T>(val data: T) : UIState<T>()
}