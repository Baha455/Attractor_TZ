package com.example.firstscreen.domain.model


data class MyModel(
	val user: User
)
data class User(
	val first_name: String,
	val photo: String,
	val second_name: String,
	val education: Int,
	val company: List<Company>
)

data class Company(
	val name: String,
	val position: String
)