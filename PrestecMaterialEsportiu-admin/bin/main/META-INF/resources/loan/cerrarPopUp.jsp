<%@ include file="init.jsp"%>
<aui:script>
    function closeThis(){
        Liferay.Util.getOpener().<portlet:namespace />closePopup('<portlet:namespace />popUpDialog');
    }
    closeThis();
</aui:script>