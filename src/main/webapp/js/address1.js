const URL = "http://localhost:8080/api/AddressManagementController";
$(function () {
    loadData();

    function loadData() {
        let params = {
            action: "getData",
            userId: 1
        }
        $.post(URL, params, function (result) {
            if (result.status === 200) {
                showAddresses(result.data.addresses);
            } else {
                alert("网络异常")
            }
        })
    }

    function showAddresses(addresses) {
        var i = 0;
        for (const address of addresses) {
            if (address.status === 1) {
                $("#addresses").append(
                    $('<li class="user-addresslist defaultAddr">').append(
                        $('<span name="' + address.addressId + '" class="new-option-r">').append(
                            $('<i class="am-icon-check-circle">')
                        ).append(
                            "设为默认"
                        )
                    ).append(
                        $('<p class="new-tit new-p-re">').append(
                            $('<span class="new-txt">').text(address.recipientName)
                        ).append(
                            $('<span class="new-txt-rd2">1').text(address.recipientPhone)
                        )
                    ).append(
                        $('<div class="new-mu_l2a new-p-re">').append(
                            $('<p class="new-mu_l2cw">').append(
                                $('<span class="title">地址：</span>')
                            ).append(
                                $('<span class="province">').text(address.addressProvince)
                            ).append(
                                $('<span class="city">').text(address.addressCity)
                            ).append(
                                $('<span class="dist">').text(address.addressCounty)
                            ).append(
                                $('<span class="street">').text(address.addressDetailed)
                            )
                        )
                    ).append(
                        $('<div class="new-addr-btn">').append(
                            $('<a href="#"><i class="am-icon-edit"></i>编辑</a>')
                        ).append(
                            $('<span class="new-addr-bar">|</span>')
                        ).append(
                            $('<a name="' + address.addressId + '" href="javascript:void(0); class="del"><i class="am-icon-trash"></i>删除</a>')
                        )
                    )
                );
            } else {
                $("#addresses").append(
                    $('<li class="user-addresslist">').append(
                        $('<span name="' + address.addressId + '" class="new-option-r">').append(
                            $('<i class="am-icon-check-circle">')
                        ).append(
                            "设为默认"
                        )
                    ).append(
                        $('<p class="new-tit new-p-re">').append(
                            $('<span class="new-txt">').text(address.recipientName)
                        ).append(
                            $('<span class="new-txt-rd2">1').text(address.recipientPhone)
                        )
                    ).append(
                        $('<div class="new-mu_l2a new-p-re">').append(
                            $('<p class="new-mu_l2cw">').append(
                                $('<span class="title">地址：</span>')
                            ).append(
                                $('<span class="province">').text(address.addressProvince)
                            ).append(
                                $('<span class="city">').text(address.addressCity)
                            ).append(
                                $('<span class="dist">').text(address.addressCounty)
                            ).append(
                                $('<span class="street">').text(address.addressDetailed)
                            )
                        )
                    ).append(
                        $('<div class="new-addr-btn">').append(
                            $('<a href="#"><i class="am-icon-edit"></i>编辑</a>')
                        ).append(
                            $('<span class="new-addr-bar">|</span>')
                        ).append(
                            $('<a class="del" name="' + address.addressId + '" href="javascript:void(0);"><i class="am-icon-trash"></i>删除</a>')
                        )
                    )
                );
            }
            if (address.status === 1) {
                $("#addresses > li :eq(" + i + ")").addClass("defaultAddr");
                $("#addresses > li :eq(" + i + ") > span").text("默认地址");
            }
            i++;
        }
    }

    $("#add").click(function () {
        var recipientName = $("#recipientName").val();
        var recipientPhone = $("#recipientPhone").val();
        var addressProvince = $("#addressProvince").val();
        var addressCity = $("#addressCity").val();
        var addressCounty = $("#addressCounty").val();
        var addressDetailed = $("#addressDetailed").val();
        if (recipientName == undefined || recipientPhone == undefined || addressProvince == undefined || addressCity == undefined || addressCounty == undefined || addressDetailed == undefined) {
            alert("每一项都不能为空")
            return false;
        }
        if (recipientName == null || recipientPhone == null || addressProvince == null || addressCity == null || addressCounty == null || addressDetailed == null) {
            alert("每一项都不能为空")
            return false;
        }
        if (recipientName == "" || recipientPhone == "" || addressProvince == "" || addressCity == "" || addressCounty == "" || addressDetailed == "") {
            alert("每一项都不能为空")
            return false;
        }
        let params = {
            action: "addAddress",
            userId: 1,
            recipientName: recipientName,
            recipientPhone: recipientPhone,
            addressProvince: addressProvince,
            addressCity: addressCity,
            addressCounty: addressCounty,
            addressDetailed: addressDetailed
        }
        $.post(URL, params, function (result) {
            if (result.status === 200) {
                $("#addresses > li").remove();
                showAddresses(result.data.addresses);
            }
        })
    });

    /**
     *  点击设为默认
     */
    $(document).on("click", '.new-option-r', function () {
        var addressId = $(this).attr("name");
        let params = {
            action: "setDefaultAddress",
            userId: 1,
            addressId: addressId
        }
        $.post(URL, params, function (result) {
            if (result.status === 200) {
                // $("#addresses > li").removeClass("defaultAddr");
                // $(this).parent().addClass("defaultAddr");
            } else {
                alert("网路异常")
            }
        })
        $("#addresses > li").removeClass("defaultAddr");
        $(this).parent().addClass("defaultAddr");

    })
    $(document).on("click", '.del', function () {
        var addressId = $(this).attr("name");
        let params = {
            action: "deleteAddress",
            userId: 1,
            addressId: addressId
        }
        $.post(URL, params, function (result) {
            if (result.status === 200) {
                // $(this).parent().parent().remove();
            } else {
                alert("网路异常")
            }
        })
        $(this).parent().parent().remove();
    })
})