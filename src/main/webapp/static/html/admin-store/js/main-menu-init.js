$('.main-menu').find('.list-group-item').on('click', function () {
    if ($(this).hasClass('active')) {
        $('.sub-menu').show();
    } else {
        $(this).siblings().removeClass('list-group-item-info');
        $(this).addClass('list-group-item-info');
        $('.sub-menu').hide();
        $('#sub-menu-' + $(this).data('toggle')).show();
    }
});