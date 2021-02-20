<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"/>
    <h1>Monitor Sensors</h1>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">Name</th>
          <th scope="col">Model</th>
          <th scope="col">Type</th>
          <th scope="col">Range</th>
          <th scope="col">Unit</th>
          <th scope="col">Location</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${sensorList}" var="sensorItem">
        <tr>
          <th scope="row">#</th>
          <td>${sensorItem.sensorId}</td>
          <td>${sensorItem.sensorName}</td>
          <td>${sensorItem.sensorModel}</td>
          <td>${sensorItem.sensorType}</td>
          <td>${sensorItem.sensorRange}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
<jsp:include page="footer.jsp"/>
