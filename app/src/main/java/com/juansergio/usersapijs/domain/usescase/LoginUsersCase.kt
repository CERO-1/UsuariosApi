package com.juansergio.usersapijs.domain.usescaseimport com.juansergio.usersapijs.data.UsuariosResponseimport com.juansergio.usersapijs.data.model.UsuariosItemimport com.juansergio.usersapijs.data.reposytory.RepositoryLoginUsersimport com.juansergio.usersapijs.data.reposytory.RepositoryUsersclass LoginUsersCase {    private  val usersrepository= RepositoryLoginUsers()    suspend  fun getData (users: String) :UsuariosResponse{        return usersrepository.Loginuser(users)    }}