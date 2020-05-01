package com.wj.shopmanagermobile.Contract

interface ILoginContract {
    interface Presenter {

    }

    interface View {
        fun userLoggedIn(result : String?)
        fun userNotLoggedIn(result : String?)
    }
}