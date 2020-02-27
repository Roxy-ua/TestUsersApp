package com.example.tapasoft.testusersapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Name(
    @SerializedName("title") val title: String?,
    @SerializedName("first") val first: String?,
    @SerializedName("last") val last: String?
): Parcelable

@Parcelize
data class Street(
    @SerializedName("number") val number: Int?,
    @SerializedName("name") val name: String?
): Parcelable

@Parcelize
data class Coordinate(
    @SerializedName("latitude") val latitude: String?,
    @SerializedName("longitude") val longitude: String?
): Parcelable

@Parcelize
data class Timezone(
    @SerializedName("offset") val offset: String?,
    @SerializedName("description") val description: String?
): Parcelable

@Parcelize
data class DateOfBirth(
    @SerializedName("date") val date: String?,
    @SerializedName("age") val age: Int?
): Parcelable

@Parcelize
data class Location(
    @SerializedName("street") val street: Street,
    @SerializedName("city") val city: String?,
    @SerializedName("state") val state: String?,
    @SerializedName("country") val country: String?,
    @SerializedName("postcode") val postcode: String?,
    @SerializedName("coordinates") val coordinates: Coordinate,
    @SerializedName("timezone") val timezone: Timezone
): Parcelable

@Parcelize
data class Id(
    @SerializedName("name") val name: String?,
    @SerializedName("value") val value: String?
): Parcelable

@Parcelize
data class Picture(
    @SerializedName("large") val large: String?,
    @SerializedName("medium") val medium: String?,
    @SerializedName("thumbnail") val thumbnail: String?
): Parcelable

@Parcelize
data class User(
    @SerializedName("gender") val gender: String?,
    @SerializedName("name") val name: Name,
    @SerializedName("location") val location: Location,
    @SerializedName("email") val email: String?,
    @SerializedName("dob") val dob: DateOfBirth,
    @SerializedName("phone") val phone: String?,
    @SerializedName("cell") val cell: String?,
    @SerializedName("id") val id: Id,
    @SerializedName("picture") val picture: Picture,
    @SerializedName("nat") val nat: String?
): Parcelable

data class AddInfo(
    @SerializedName("seed") val seed: String?,
    @SerializedName("results") val results: Int?,
    @SerializedName("page") val page: Int?,
    @SerializedName("version") val version: String?
)

data class PersonPage(
    @SerializedName("results") val users: List<User>,
    @SerializedName("info") val info: AddInfo
)

