function getParent(element,level) {
    var a = $(element);
    for(i=0;i<level;++i){
        a = $(a).parent();
    }
    return $(a);
}

function UpdateFoodItem(ButtonUpdate) {
    var MessageModal =

<div class="modal fade bs-example-modal-lg in" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" style="display: block; padding-right: 17px;">
        <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">

        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
    <h4 class="modal-title" id="myLargeModalLabel">Large modal</h4>
    </div>
    <div class="modal-body">
        商品信息已更新
    </div>
    </div>
    </div>
    </div>

}

function FoodItemsInit() {
    if($('#food-items').length==0){
        setTimeout(FoodItemsInit,1000);
        return;
    }
    $('#food-items').empty();
    $.getJSON('../api/admin-store-good-type.json',function (data) {
        // nav tabs
        $('#food-items')
            .append('<ul class="nav nav-tabs">');
        for(i=0;i<data.length;++i) {
            $('#food-items > ul.nav.nav-tabs')
                .append('<li class="' + (i==0?' active':'') + '"><a href="#food-type-'+i+'" data-toggle="tab">'+data[i].name+'</a></li>');
        }
        // tab panels
        $('#food-items')
            .append('<div class="tab-content">');
        for(i=0;i<data.length;++i) {
            $('#food-items > div.tab-content')
                .append('<div class="tab-pane' + (i==0?' active':'') + '" id="food-type-'+i+'">');
            for(j=0;j<data[i].foodList.length;++j) {
                var fooddesc = data[i].foodList[j].description;
                $('#food-items > div.tab-content > div.tab-pane#food-type-'+i).append(
                    '<div class="col-md-4 col-sm-6 col-xs-10">' +
                    '    <div class="alert alert-info">' +
                    '       <div class="media">' +
                    '            <div class="media-left">' +
                    '                <a href="#">' +
                    '                    <img class="media-object" src="' + data[i].foodList[j].foodImg + '" style="width: 64px; height: 64px;">' +
                    '                </a>' +
                    '            </div>' +
                    '            <div class="media-body">' +
                    '                <h4 class="media-heading">' +
                    '                    <b>商品信息</b>' +
                    '                    <span class="glyphicon glyphicon-remove" style="font-size: 15px;float:right;" onclick="getParent(this,5).remove();"></span>' +
                    '                </h4>' +

                    '                <form>' +
                    '                    <div class="input-group" style="margin-top:12px;">' +
                    '                        <span class="input-group-addon">商品名</span>' +
                    '                        <input type="text" class="form-control" placeholder="' + data[i].foodList[j].foodName + '">' +
                    '                        <span class="input-group-btn">' +
                    '                            <button class="btn btn-default" type="reset">' +
                    '                                <span class="glyphicon glyphicon-refresh"></span>' +
                    '                            </button>' +
                    '                        </span>' +
                    '                    </div>' +
                    '                </form>' +

                    '                <form>' +
                    '                    <div class="input-group" style="margin-top:12px;">' +
                    '                        <span class="input-group-addon">价格</span>' +
                    '                        <input type="text" class="form-control" placeholder="' + data[i].foodList[j].price + '">' +
                    '                        <span class="input-group-btn">' +
                    '                            <button class="btn btn-default" type="reset">' +
                    '                                <span class="glyphicon glyphicon-refresh"></span>' +
                    '                            </button>' +
                    '                        </span>' +
                    '                    </div>' +
                    '                </form>' +

                    '                <form>' +
                    '                    <div class="input-group" style="margin-top:12px;">' +
                    '                        <span class="input-group-addon">类别</span>' +
                    '                        <input type="text" class="form-control" placeholder="' + data[i].foodList[j].shopFoodType + '">' +
                    '                        <span class="input-group-btn">' +
                    '                            <button class="btn btn-default" type="reset">' +
                    '                                <span class="glyphicon glyphicon-refresh"></span>' +
                    '                            </button>' +
                    '                        </span>' +
                    '                    </div>' +
                    '                </form>' +

                    '                <form>' +
                    '                    <div class="input-group" style="margin-top:12px;">' +
                    '                        <span class="input-group-addon">描述</span>' +
                    '                        <input type="text" class="form-control" placeholder="' + (fooddesc==undefined?'添加描述':'') + '" value="' + (fooddesc==undefined?'':fooddesc) + '">' +
                    '                        <div class="input-group-btn">' +
                    '                            <button type="reset" class="btn btn-default">' +
                    '                                <span class="glyphicon glyphicon-refresh"></span>' +
                    '                            </button>' +
                    '                            <button type="button" class="btn btn-default" onclick="UpdateFoodItem(this);">' +
                    '                                <span class="glyphicon glyphicon-ok"></span>' +
                    '                            </button>' +
                    '                       </div>' +
                    '                    </div>' +
                    '                </form>' +
                    '            </div>' +
                    '        </div>' +
                    '    </div>' +
                    '</div>');
            }// for j in foodType.foodList
        }// for i in foodType
    });
}


FoodItemsInit();