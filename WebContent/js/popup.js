$('#open').mouseenter(function() {
    $('#dialog_content').dialog('open');
});
$('#dialog_content').mouseleave(function() {
    $('#dialog_content').dialog('close');
});

$('#dialog_content').dialog({
    autoOpen: false,
    open: function() {
        closedialog = 1;
        $(document).bind('click', overlayclickclose);
    },
    focus: function() {
        closedialog = 0;
    },
    close: function() {
        $(document).unbind('click');
    },
    buttons: {
      /*  
      Ok: function() {
            $(this).dialog('close');
        }
        */
     },
    position: [0,0],
    resizable: false
});