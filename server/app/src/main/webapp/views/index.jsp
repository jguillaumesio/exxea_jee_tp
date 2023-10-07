<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.example.demo.utils.Misc" %>
<jsp:include page="../header.jsp" />
<div class="list">
    <div class="list-item header">
        <span>Nom - Prix (€)</span>
        <div class="list-item-actions no-hover">
            <button onclick="toggleCreate(event)">
                <svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 -960 960 960" width="24" fill="#fff"><path d="M440-280h80v-160h160v-80H520v-160h-80v160H280v80h160v160Zm40 200q-83 0-156-31.5T197-197q-54-54-85.5-127T80-480q0-83 31.5-156T197-763q54-54 127-85.5T480-880q83 0 156 31.5T763-763q54 54 85.5 127T880-480q0 83-31.5 156T763-197q-54 54-127 85.5T480-80Zm0-80q134 0 227-93t93-227q0-134-93-227t-227-93q-134 0-227 93t-93 227q0 134 93 227t227 93Zm0-320Z"/></svg>
            </button>
        </div>
    </div>
<c:forEach items="${products}" var="product">
    <div class="list-item">
        <span>${product.name} - ${Misc.floatToString(product.price)}€</span>
        <div class="list-item-actions">
            <button  onclick="toggleEdit(event, ${product.id}, '${product.name}', ${product.price})">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 -960 960 960"><path d="M200-200h56l345-345-56-56-345 345v56Zm572-403L602-771l56-56q23-23 56.5-23t56.5 23l56 56q23 23 24 55.5T829-660l-57 57Zm-58 59L290-120H120v-170l424-424 170 170Zm-141-29-28-28 56 56-28-28Z"/></svg>
            </button>
            <form action="produit" method="post">
                <input type="hidden" name="action" value="remove">
                <input type="hidden" name="id" value="${product.id}">
                <button type="submit">
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 -960 960 960"><path d="M280-120q-33 0-56.5-23.5T200-200v-520h-40v-80h200v-40h240v40h200v80h-40v520q0 33-23.5 56.5T680-120H280Zm400-600H280v520h400v-520ZM360-280h80v-360h-80v360Zm160 0h80v-360h-80v360ZM280-720v520-520Z"/></svg>
                </button>
            </form>
        </div>
    </div>
</c:forEach>
</div>
<script type="text/javascript">
    <jsp:include page="form.jsp" />
    const toggleEdit = (e, id, name, price) => {
        e.preventDefault();
        const template = getForm('Modifier', 'edit', {id, name, price});
        toggleModal('Modifier', template, false);
    }
    const toggleCreate = (e) => {
        e.preventDefault();
        const template = getForm('Créer', 'create');
        toggleModal('Créer', template, false);
    }
</script>
<jsp:include page="../footer.jsp" />
