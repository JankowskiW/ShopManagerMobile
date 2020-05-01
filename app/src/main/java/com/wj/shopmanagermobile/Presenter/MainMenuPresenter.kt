package com.wj.shopmanagermobile.Presenter

import com.wj.shopmanagermobile.Contract.IMainMenuContract


class MainMenuPresenter: IMainMenuContract.Presenter  {

    var contractView : IMainMenuContract.View

    init {
    }

    constructor(contractView : IMainMenuContract.View) {
        this.contractView = contractView
    }
}