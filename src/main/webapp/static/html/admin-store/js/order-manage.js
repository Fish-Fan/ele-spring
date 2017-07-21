var orderlistJSON;

function OpenOrder(orderid) {
    var orderJSON, foodList;
    for(i = 0; i < orderlistJSON.length; ++i){
        if(orderlistJSON[i].id==orderid) {
            orderJSON = orderlistJSON[i];
            foodList = orderJSON.foodList;
        }
    }

    $('#order-foodList > tbody').empty();

    for(i = 0; i < foodList.length; ++i) {
        $('#order-foodList > tbody').append(
            '<tr>' +
            '    <th scope="row">' + foodList[i].id + '</th>' +
            '    <td>' + foodList[i].foodName + '</td>' +
            '    <td>' + foodList[i].foodCount + '</td>' +
            '    <td>' + foodList[i].foodPrice + '</td>' +
            '</tr>');
    }
    $('#field-order-foodList').show();
}

function PrintOrders(orders) {
    orderlistJSON = orders;
    for(i = 0; i < orders.length; ++i) {
        var order = orders[i];
        $('#order-' + order.status + '-list > table > tbody').append(
            '<tr style="cursor: pointer;" onclick="OpenOrder(' + order.id + ')">' +
            '    <th scope="row">' + order.id + '</th>' +
            '    <td>' + order.username + '</td>' +
            '    <td>' + order.address + '</td>' +
            '    <td>' + order.phoneNum + '</td>' +
            '    <td>' + order.generateTime + '</td>' +
            '</tr>')
    }
}

// $.getJSON('../api/admin-store-order.json',PrintOrders);
$.getJSON('/manager/shop/order/view/day',{
    "shopId": localStorage.shopId
},PrintOrders);






function viewNewOrder(){
    $('.sub-menu').hide();
    $('#sub-menu-order').show();
}

function UpdateOrder(order) {
    $('#order-' + order.status + '-list > table > tbody').append(
        '<tr style="cursor: pointer;" onclick="OpenOrder(' + order.id + ')">' +
        '    <th scope="row">' + order.id + '</th>' +
        '    <td>' + order.username + '</td>' +
        '    <td>' + order.address + '</td>' +
        '    <td>' + order.phoneNum + '</td>' +
        '    <td>' + order.generateTime + '</td>' +
        '</tr>');
    window.orderlistJSON.push(order);
    console.log(JSON.stringify(order));
}

function UpdateOrderPopup(order) {
    var MessageModal =
        '<div id="message-modal-temp" class="modal fade in" tabindex="-1" style="display: block;">'+
        '    <div class="modal-dialog modal-sm">'+
        '        <div class="modal-content">'+
        '            <div class="modal-header">'+
        '                <button type="button" class="close" data-dismiss="modal">'+
        '                    <span aria-hidden="true">×</span>'+
        '                </button>'+
        '                <h4 class="modal-title" id="myLargeModalLabel"><b>有新的订单</b></h4>'+
        '            </div>'+
        '            <div class="modal-body text-center">'+
        '                <div class="btn btn-default" data-dismiss="modal" onclick="viewNewOrder()">查看订单</div>'+
        '            </div>'+
        '        </div>'+
        '    </div>'+
        '</div>';

    $('#message-modal-temp').remove();
    $(MessageModal).modal('show');
    UpdateOrder(order);
}

var sock = new WebSocket("ws:localhost:8080/manager/shop/getorder");

if(sock==undefined) alert('error initiating websocket');

sock.onopen = function (e) {
    console.log(e);
    sendMessage("web socket open");
};

sock.onmessage = function (e) {
    console.log(e);
    UpdateOrderPopup(JSON.parse(e.data));
};

sock.onerror = function (e) {
    console.log(e);
};

sock.onclose = function (e) {
    console.log(e);
};

function sendMessage(message) {
    console.log("sendMessage('" + message + ")");
    sock.send(message);
}

/*  only for testing

 $.getJSON('../api/admin-store-order-new.json',function (data) {
 OrderTemp = data;
 })

 setTimeout(UpdateOrderPopup,3000);

 */