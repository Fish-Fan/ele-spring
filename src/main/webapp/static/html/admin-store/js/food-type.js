function FoodTypesInit() {
    var FoodTypeTable = $('#table-food-type > tbody');
    if(FoodTypeTable.length==0){
        setTimeout(FoodTypesInit,1000);
        return;
    }
    var discounts = {
        "1": {name:"满减",class:"primary"},
        "2": {name:"折扣",class:"success"},
        "3": {name:"特价",class:"info"},
        "4": {name:"支持发票",class:"warning"},
        "5": {name:"外卖保",class:"danger"}
    };
    FoodTypeTable.empty();
    $.getJSON('../api/admin-store-food-type.json',function (data) {
        for(i=0;i<data.length;++i){
            var FoodTypeRow = $('<tr>');
            var foodTypeId = data[i].foodTypeId;
            var foodTypeName = data[i].shopFoodType;
            var discountId = data[i].iconId;
            FoodTypeRow.append('<td class="text-center">' + (foodTypeId==undefined?('#'+(i+1)):foodTypeId) + '</td>');
            FoodTypeRow.append('<td class="text-center">' + foodTypeName + '</td>');
            FoodTypeRow.append('<td class="text-center">' + (discountId==undefined?'没有活动':'<span class="label label-'+discounts[discountId].class+'" style="font-size: 13px;">'+discounts[discountId].name+'</span>') + '</td>');
            FoodTypeRow.append('<td class="text-center"><div class="btn btn-default">编辑</div></td>');
            FoodTypeRow.append('<td class="text-center"><div class="btn btn-danger">删除</div></td>');
            FoodTypeTable.append(FoodTypeRow);
        }
    });
}

FoodTypesInit();