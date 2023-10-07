let modal;
window.addEventListener('DOMContentLoaded',() => {
    modal = document.querySelector("#modal");
});
const toggleModal = (title = '', content = '', forceClose = true) => {
    const contentDom = modal.querySelector('.body');
    const titleDom = modal.querySelector('.title');
    if(modal && contentDom && titleDom){
        modal.classList.add('close');
        contentDom.innerHTML = content;
        titleDom.innerHTML = title;
        if(forceClose){
            modal.classList.add('close');
        } else {
            modal.classList.remove('close');
        }
    }
}

const set_field_error = (fieldName, message) => {
    let fieldWrapper = document.querySelector(`label > *[name='${fieldName}']`);
    if(fieldWrapper){
        fieldWrapper = fieldWrapper.parentElement;
        fieldWrapper.classList.add("error");
        const spanElement = fieldWrapper.querySelector(".label_error");
        if(spanElement){
            spanElement.innerHTML = message;
        }
    }
}

const is_form_valid = (name, price) => {
    const nameRegex = /^[A-Za-zÀ-ÖØ-öø-ÿ ]{2,}$/; // accepts only letters and spaces
    const priceRegex = /^[0-9]*([.,][0-9]{1,2})?$/; // accepts only 2 uppercase letters
    let result = true;
    if ([undefined, null, ""].includes(name)) {
        set_field_error("name","Tu dois renseigné un nom au produit !");
        result = false;
    } else if (!nameRegex.test(name)){
        set_field_error("name", "Le nom du produit ne peut contenir que des lettres et des espaces");
        result = false;
    }

    if ([undefined, null, ""].includes(price)) {
        set_field_error("price","Tu dois renseigné un prix au produit !");
        result = false;
    } else if (!priceRegex.test(price)){
        set_field_error("price","Le prix du produit doit être un entier ou un nombre décimal produit !");
        result = false;
    }

    return result;
}

const reset_fields_error = () => {
    document.querySelectorAll(`label.error > .label_error`).forEach(e => {
        e.parentElement.classList.remove("error");
        const spanElement = e.parentElement.querySelector(".label_error");
        if(spanElement){
            spanElement.innerHTML = "";
        }
    })
}

const validate_form = async (e) => {
    e.target.setAttribute("disabled", true);
    reset_fields_error();
    const fields = {
        "name": document.querySelector("#produit_form input[name='name']")?.value,
        "price": document.querySelector("#produit_form input[name='price']")?.value,
    }
    const result = is_form_valid(fields.name,fields.price);
    if(!result){
        e.preventDefault();
    }
}