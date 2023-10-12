const getForm = (submit, type, product = null) => {
  return '<form id="produit_form" method="post" action="produit" onsubmit="return validate_form(event)">'
  +'<input type="hidden" name="action" value="' + type + '">'
  + (product !== null ? '<input type="hidden" name="id" value="' + product.id + '">' : '')
  +'<label for="name">Nom'
  +'<input id="name" type="text" name="name" value="' + (product?.name ? product.name : '') + '">'
  +'<span class="label_error"></span>'
  +'</label>'
  +'<label for="price">Prix'
  +'<input id="price" type="text" name="price" value="' + (product?.price ? product.price : '') + '">'
  +'<span class="label_error"></span>'
  +'</label>'
  +'<button type="submit" style="width:fit-content;margin:.5rem;padding:.5rem 1rem;color:#fff;background:#4D8CEA;border-radius:1rem;align-self:center;">' + submit + '</button>'
  +'</form>';
}