<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="bond" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="xxx" %>

<bond:set var="List" value="${sessionScope.data}"></bond:set>
<bond:set var="index" value="${xxx:length(List)}"></bond:set>
[

<bond:forEach items="${List}" var="x" varStatus="Counter">

{
	"subCategoryId" :"${x.subCategoryId}",
	"subCategoryName" :"${x.subCategoryName}"
}

<bond:if test="${index ne Counter.count}" >,</bond:if>

</bond:forEach>

] 	