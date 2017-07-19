function AddOpenStoreListItem(list,item) {
    var colFirst = $('<div class="col-md-2">');
    var colFirstText = $('<div class="open-store-instruction-item-number">');
    colFirstText.text(item.number);

    var colSecond = $('<div class="col-md-8">');
    var colSecondText =
        '<div style="padding-top:16px;">' +
        '    <span class="open-store-instruction-item-name">' + item.name + '</span>' +
        '    <span class="open-store-instruction-item-description">' + item.desc + '</span>' +
        '</div>';

    var colThird = $('<div class="col-md-2 sample-image">');
    var colThirdText = $('<img class="open-store-instruction-img">');
    colThirdText.attr('src','../img/'+item.sample);

    var row = $('<div class="row open-store-instruction-item">');
    var li = $('<li class="list-group-item">');

    colFirst.append(colFirstText);
    colSecond.append(colSecondText);
    colThird.append(colThirdText);
    row.append(colFirst);
    row.append(colSecond);
    row.append(colThird);
    li.append(row);
    $(list).append(li);
}


$('#open-store-certificates').empty();
AddOpenStoreListItem($('#open-store-certificates'),{number:1,name:'身份证照片',desc:'证件照需清晰可辨认，不能使用复印件',sample:'open-store-certificate-1.png'});
AddOpenStoreListItem($('#open-store-certificates'),{number:2,name:'营业执照',desc:'正面拍摄证件，证件照需清晰可辨认，不能使用复印件',sample:'open-store-certificate-2.png'});
AddOpenStoreListItem($('#open-store-certificates'),{number:3,name:'餐饮行业许可证',desc:'正面拍摄证件，证件照需清晰可辨认，不能使用复印件',sample:'open-store-certificate-3.png'});
$('#open-store-documents').empty();
AddOpenStoreListItem($('#open-store-documents'),{number:1,name:'店内照片',desc:'照片体现店铺环境，照片不能有水印，logo和其他网站信息',sample:'open-store-document-1.png'});
AddOpenStoreListItem($('#open-store-documents'),{number:2,name:'门脸照片',desc:'店面招牌和店面大门全景拍摄，照片不能有水印，logo和其他网站信息',sample:'open-store-document-2.png'});
AddOpenStoreListItem($('#open-store-documents'),{number:3,name:'商品照片',desc:'对真实商品拍摄的照片，照片不能有水印，logo和其他网站信息',sample:'open-store-document-3.png'});
AddOpenStoreListItem($('#open-store-documents'),{number:4,name:'商户Logo',desc:'符合商品气质的店铺标志',sample:'open-store-document-4.png'});


$('#myModal').modal('toggle')