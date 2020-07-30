<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="bond" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="xxx" %>

<bond:set var="List" value="${sessionScope.data}"></bond:set>
<bond:set var="index" value="${xxx:length(List)}"></bond:set>
[

<bond:forEach items="${List}" var="x" varStatus="Counter">

{
	"cityId" :"${x.cityId}",
	"cityName" :"${x.cityName}"
}

<bond:if test="${index ne Counter.count}" >,</bond:if>

</bond:forEach>

] 	