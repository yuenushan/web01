$(function () {
    $('#startTime').datetimepicker({
        language:  'zh-CN',
        format: 'yyyy-mm-dd',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
    $('#endTime').datetimepicker({
        language:  'zh-CN',
        format: 'yyyy-mm-dd',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
});

function generate() {
    var header = $("meta[name='_csrf_header']").attr("content");
    var token =$("meta[name='_csrf']").attr("content");
    var formData = {
        name: $("#name").val(),
        code: $("#code").val(),
        startTime: $("#startTime").val(),
        endTime: $("#endTime").val()
    };
    if (formData.hospitalName != '' && formData.hardCode != '' && formData.startTime != '' && formData.endTime != '') {
        $.ajax({
            type: 'POST',
            contentType:"application/json",
            url: '/content',
            dataType: 'json',
            data: JSON.stringify(formData),
            beforeSend : function(xhr) {
                xhr.setRequestHeader(header, token);
            },
            success: function (data) {
                if (data.status == 0) {
                    $( "#result" ).html(`<div class="alert alert-success" role="alert">${data.message}</div>`);
                    var code = data.data.content;
                    var blobContent = new Blob(
                        [code],
                        {type : 'text/plain'}
                    );
                    var blobUrl = window.URL.createObjectURL(blobContent)
                    downloadFileByBlob(blobUrl, 'content.txt')
                } else {
                    $( "#result" ).html(`<div class="alert alert-danger" role="alert">${data.message}</div>`);
                }
            },
            error:function(XMLHttpRequest, textStatus){
                $( "#result" ).html(`<div class="alert alert-danger" role="alert">服务器异常</div>`);
            }
        });
    }
}

function downloadFileByBlob(blobUrl, filename) {
    var eleLink = document.createElement('a');
    eleLink.download = filename;
    eleLink.style.display = 'none';
    eleLink.href = blobUrl;
    // 触发点击
    document.body.appendChild(eleLink);
    eleLink.click();
    // 然后移除
    document.body.removeChild(eleLink);
}