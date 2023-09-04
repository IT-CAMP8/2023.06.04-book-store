function addToCart(id) {
    $.ajax({
        url: "http://localhost:8080/api/v1/cart/add/" + id,
        method: "GET"
    })
    .done(wynik => {

    });

    saveBook();
}

function saveBook() {

    var book = {
        id: 0,
        title: "Nowa skiazka z ajaxa",
        author: "javaScript",
        price: 666.66,
        quantity: 66,
        isbn: "123-123-123"
    };

    $.ajax({
        url: "http://localhost:8080/api/v1/book",
        method: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(book)
    })
    .done(book => {
        console.log(book.id);
        console.log(book.title);
        console.log(book.author);
        console.log(book.price);
        console.log(book.quantity);
        console.log(book.isbn);
    });
}