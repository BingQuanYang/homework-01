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
        for (const address of addresses) {
            $("#addresses").append(
                $('<li class="user-addresslist">').append(
                    $('<span class="new-option-r">').append(
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
                        $('<a href="javascript:void(0);"><i class="am-icon-trash"></i>删除</a>')
                    )
                )
            )
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
    })
})