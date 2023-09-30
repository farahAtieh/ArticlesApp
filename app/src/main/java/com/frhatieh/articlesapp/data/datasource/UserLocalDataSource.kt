package com.frhatieh.articlesapp.data.datasource

import com.frhatieh.articlesapp.data.database.dao.UserDao
import com.frhatieh.articlesapp.data.model.UserEntity

class UserLocalDataSource(
    private val userDao: UserDao
) {
    fun getUser(uid: String) =
        userDao.getUser(uid)

    fun saveUser(userEntity: UserEntity) =
        userDao.insertUser(userEntity)


    fun removeUser() =
        userDao.clear()


}