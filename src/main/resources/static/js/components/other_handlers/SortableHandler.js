import {renderCss,callApiPost} from "../../common/common.js";

$(() => {
    var idSorted = null;
    $("#main-profile").sortable({
        animation: 150,
        opacity: 0.2,
        cursor:"move",
        start: function(event,ui){
            idSorted = ui.item.attr("id");
            renderCss(idSorted,"border","1px dotted black");
        },
        stop: function (event,ui){
            renderCss(idSorted,"border","none");
        },
        update: function (event,ui){
            let arraySorted = $("#main-profile").sortable("toArray");
            callApiPost("/api/v1/admin/save-sortable",arraySorted.join(","));
        }
    });
});