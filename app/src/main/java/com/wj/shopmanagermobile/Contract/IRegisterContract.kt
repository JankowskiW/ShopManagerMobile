package com.wj.shopmanagermobile.Contract

interface IRegisterContract {
    interface Presenter {

    }

    interface View {
        fun userRegistered(userName: String)
        fun userExists(userName : String)
    }
}