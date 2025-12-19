let books = [];

function addBook() {
    let book = {
        id: bookId.value,
        title: title.value,
        author: author.value,
        price: price.value,
        available: true
    };

    books.push(book);
    showMessage("Book added successfully!");
}

function searchBook() {
    let value = searchValue.value.toLowerCase();
    let result = books.filter(b =>
        b.title.toLowerCase().includes(value) ||
        b.author.toLowerCase().includes(value)
    );

    displayBooks(result);
}

function rentBook() {
    let id = rentId.value;
    let book = books.find(b => b.id == id);

    if (book && book.available) {
        book.available = false;
        showMessage("Book rented successfully!");
    } else {
        showMessage("Book not available or not found!");
    }
}

function returnBook() {
    let id = rentId.value;
    let book = books.find(b => b.id == id);

    if (book && !book.available) {
        book.available = true;
        showMessage("Book returned successfully!");
    } else {
        showMessage("Book not rented or not found!");
    }
}

function showAvailable() {
    displayBooks(books.filter(b => b.available));
}

function showRented() {
    displayBooks(books.filter(b => !b.available));
}

function displayBooks(list) {
    let out = "";
    list.forEach(b => {
        out += `
        Book ID: ${b.id}<br>
        Title: ${b.title}<br>
        Author: ${b.author}<br>
        Price: ${b.price}<br>
        Status: ${b.available ? "Available" : "Rented"}<hr>`;
    });
    output.innerHTML = out;
}

function showMessage(msg) {
    output.innerHTML = "<b>" + msg + "</b>";
}
