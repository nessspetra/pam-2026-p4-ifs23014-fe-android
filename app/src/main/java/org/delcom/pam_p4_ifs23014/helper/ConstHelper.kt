package org.delcom.pam_p4_ifs23014.helper

class ConstHelper {
    // Route Names
    enum class RouteNames(val path: String) {
        Home(path = "home"),
        Profile(path = "profile"),
        Plants(path = "plants"),
        PlantsAdd(path = "plants/add"),

        PlantsDetail(path = "plants/{plantId}"),
        PlantsEdit(path = "plants/{plantId}/edit"),

        Foods(path = "foods"),
        FoodsAdd(path = "foods/add"),
        FoodsDetail(path = "foods/{foodId}"),
        FoodsEdit(path = "foods/{foodId}/edit"),
    }
}