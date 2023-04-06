function attachEvents() {
  const BASE_URL = "http://localhost:3030/jsonstore/phonebook";
  const ul = document.getElementById("phonebook");

  const loadBtn = document.getElementById("btnLoad");
  loadBtn.addEventListener("click", loadContacts);
  const createBtn = document.getElementById("btnCreate");
  createBtn.addEventListener("click", createContact);

  async function createContact() {
    const name = document.getElementById("person");
    const phone = document.getElementById("phone");

    const contact = {
      person: name.value,
      phone: phone.value,
    };

    const settings = {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(contact),
    };
    try {
      const response = await fetch(BASE_URL, settings);
      let data = await 
      response.json();

      console.log(data);
    } catch (err) {
      console.error(err);
    }
    name.value = '';
    phone.value = '';
    loadContacts();
  }

  async function loadContacts() {
    try {
      ul.textContent = '';
      const response = await fetch(BASE_URL);
      let data = await response.json();
      let phoneBookData = Object.values(data);

      for (const { person, phone, _id } of phoneBookData) {
        const li = document.createElement("li");
        li.textContent = `${person}: ${phone}`;
        const delBtn = document.createElement("button");
        delBtn.id = _id;
        delBtn.textContent = "Delete";
        delBtn.addEventListener("click", deleteContent);

        li.appendChild(delBtn);
        ul.appendChild(li);
      }
    } catch (err) {
      console.error(err);
    }
  }

  async function deleteContent() {
    const id = this.id;
   
    const settings = {
      method: 'DELETE'  
    }

    try {
      const response = await fetch(BASE_URL + "/" + id, settings);
      let data = await response.json();
      
      console.log(data);
      loadContacts();
    } catch (err) {
      console.error(err);
    }
  }
}

attachEvents();
