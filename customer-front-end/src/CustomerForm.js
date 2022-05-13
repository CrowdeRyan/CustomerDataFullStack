import { useState } from "react";

function CustomerForm({ customer: initialCustomer, notify }) {
  const [customer, setCustomer] = useState(initialCustomer);
  const isAdd = initialCustomer.id === 0;

  function handleChange(evt) {
    const clone = { ...customer };
    clone[evt.target.name] = evt.target.value;
    setCustomer(clone);
  }

  function handleSubmit(evt) {
    evt.preventDefault();

    const url = isAdd
      ? "http://localhost:8080/customer"
      : `http://localhost:8080/customer/${customer.id}`;
    const method = isAdd ? "POST" : "PUT";
    const expectedStatus = isAdd ? 201 : 204;

    const init = {
      method,
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
      },
      body: JSON.stringify(customer),
    };

    fetch(url, init)
      .then((response) => {
        if (response.status === expectedStatus) {
          if (isAdd) {
            return response.json();
          } else {
            return customer;
          }
        }
        return Promise.reject(
          `Didn't receive expected status: ${expectedStatus}`
        );
      })
      .then((result) =>
        notify({
          action: isAdd ? "add" : "edit",
          customer: result,
        })
      )
      .catch((error) => notify({ error: error }));
  }

  return (
    <>
      <h1>{customer.id > 0 ? "Edit" : "Add"} Customer</h1>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="firstName">First Name</label>
          <input
            type="text"
            id="firstName"
            name="firstName"
            className="form-control"
            value={customer.firstName}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="lastName">Last Name</label>
          <input
            type="text"
            id="lastName"
            name="lastName"
            className="form-control"
            value={customer.lastName}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="street">Street</label>
          <input
            type="text"
            id="street"
            name="street"
            className="form-control"
            value={customer.street}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="city">City</label>
          <input
            type="text"
            id="city"
            name="city"
            className="form-control"
            value={customer.city}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="state">State</label>
          <input
            type="text"
            id="state"
            name="state"
            className="form-control"
            value={customer.state}
            onChange={handleChange}
          />
        </div>

        <div className="mb-3">
          <label htmlFor="zip">Zip</label>
          <input
            type="text"
            id="zip"
            name="zip"
            className="form-control"
            value={customer.zip}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="level">Level</label>
          <input
            type="text"
            id="level"
            name="level"
            className="form-control"
            value={customer.level}
            onChange={handleChange}
          />
        </div>
        <div className="mb-3">
          <button className="btn btn-primary mr-3" type="submit">
            Save
          </button>
          <button
            className="btn btn-secondary"
            type="button"
            onClick={() => notify({ action: "cancel" })}
          >
            Cancel
          </button>
        </div>
      </form>
    </>
  );
}

export default CustomerForm;
