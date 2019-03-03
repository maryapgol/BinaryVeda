package com.binaryveda.aniket.binaryveda.Model

/**
 * Created by Aniket on 03-03-2019.
 */
data class SeekerResponse(

        val data: SeekerData?
)

data class SeekerData
(

        val id: Int?,
        val name: String?,
        val image: String?,
        val designation: Designation?,
        val roles: List<Roles>?,
        val industries: List<Industries>?,
        val work_functions: List<WorkFunction>?,
        val skills: List<Skills>?,
        val highest_qualification: HighestQualification?,
        val last_company: LastCompany?,
        val experience: String?,
        val expected_ctc: String?,
        val location:String?

)

data class Designation
(
        val id: Int?,
        val name: String?

)

data class Roles
(
        val id: Int?,
        val name: String?

)

data class Industries
(
        val id: Int?,
        val name: String?
)

data class WorkFunction
(

        val id: Int?,
        val name: String?
)

data class Skills(
        val id: Int?,
        val name: String?
)

data class HighestQualification
(
        val id: Int?,
        val name: String?
)

data class LastCompany(

        val id: Int?,
        val name: String?
)


