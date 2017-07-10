<style>
    header {
        height: 60px!important;
    }
</style>
<header class="mui-bar mui-bar-nav" style="background-image: linear-gradient(90deg,#0af,#0085ff);color:white;">
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left" style="color:white" data-target="history.html"></a>
    <h1 class="mui-title">
        <div style="color:white">订单配送至</div>
        <div style='position:relative; top:-20px;color:white;'>天津工业大学软件园</div>
    </h1>
</header>
<br />
<br />
<br />

<div class="mui-card">
    <div class="mui-card-content">
        <div class="mui-card-content-inner">
            <div class="mui-navigate-right">
                尽快送达[预计18:31]
            </div>
        </div>
    </div>
</div>


<div class="mui-card">
    <div class="mui-card-header mui-text-center">
        <p style="color:#444;width:100%;">百圣格西式快餐</p>
    </div>
    <div class="mui-card-content">
        <div class="mui-card-content-inner">
            <div class="mui-row">
                <div class="mui-col-xs-6 mui-text-left">宫保鸡丁</div>
                <div class="mui-col-xs-6 mui-text-right">8.0 * 1</div>
            </div>
            <div class="mui-row">
                <div class="mui-col-xs-6 mui-text-left">鱼香肉丝</div>
                <div class="mui-col-xs-6 mui-text-right">8.0 * 1</div>
            </div>
            <div class="mui-row">
                <div class="mui-col-xs-6 mui-text-left">米饭</div>
                <div class="mui-col-xs-6 mui-text-right">1.0 * 2</div>
            </div>
            <div class="mui-row">
                <div class="mui-col-xs-6 mui-text-left">红包</div>
                <div class="mui-col-xs-6">
                    <div class="mui-row">
                        <div class="mui-col-xs-10 mui-text-right">
                            <span class='mui-badge mui-badge-danger'>9个可用</span>
                        </div>
                        <div class="mui-col-xs-1">
                        </div>
                        <div class="mui-col-xs-1 mui-text-right">
                            <a class="mui-navigate-right" style='position:relative;left:10px;'>
                                &nbsp;
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="mui-row">
                <div class="mui-col-xs-6 mui-text-left">合计</div>
                <div class="mui-col-xs-6 mui-text-right">18.0</div>
            </div>
        </div>
    </div>
    <div class="mui-card-footer">
        <a class="mui-card-link">催单</a>
        <a class="mui-card-link">详情</a>
        <a class="mui-card-link">确认收货</a>
    </div>
</div>
<div class="mui-card">
    <div class="mui-card-content">
        <div class="mui-input-row mui-checkbox">
            <label>
                成为超级会员！
                <span style='float:right'>
							<h6 style='display:inline'>
									<del>¥15</del>
							</h6>
							¥10
						</span>
                <br>
                <small><span class="mui-badge mui-badge-danger mui-badge-inverted">每月返20元红包,本单减5元</span></small>
            </label>
            <input name="checkbox1" type="checkbox">
        </div>
    </div>
</div>

<nav class="mui-bar mui-bar-tab" style="height:50px;">
    <ul class="mui-table-view" style="height:50px;">
        <li class="mui-table-view-cell">
            ¥27
            <button class="mui-btn mui-btn-blue" data-target="pay.html">
                去支付
            </button>
        </li>
    </ul>
</nav>

<script>
    $('[data-target]').on('click tap',function(){
        loadWindow($(this).data('target'))
    })
</script>