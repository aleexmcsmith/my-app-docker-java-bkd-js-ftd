console.log("Java End Point Consumption Script Loaded");
// const url = "http://localhost:8080"; 
const url - "https://my-app-docker-backend.onrender.com"
const btnEl = document.getElementById('btn');
const numEl = document.getElementById('num');
const dataContainer = document.getElementById('data-container');

btnEl.addEventListener('click', () => {
    const todoId = numEl.value || 1;
    displayData(todoId);
    dataContainer.style.display = 'block';
    numEl.value = '';
});



// Function to consume a Java endpoint
async function consumeJavaEndpoint(todoId) {
    try {
        const options = {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        };
        
        const response = await fetch(`${url}/new/${todoId}`, options);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        console.log("Response from Java endpoint:", data);
        // alert("Data received: " + JSON.stringify(data));
        return data;
    }catch (error) {
        console.error("Error consuming Java endpoint:", error);
    }
}

async function displayData(id = 1) {
    const response = await consumeJavaEndpoint(id);
    // console.log("Displaying data on webpage:" + JSON.stringify(response));
    const container = document.getElementById('data-container');
    container.innerHTML = `<p>${JSON.stringify(response)}</p>
    <p>id: ${response.id}</p>
    <p>user id: ${response.userId}</p>
    <p>title: ${response.title}</p>
    <p>completed: ${response.completed}</p>`;
}
displayData(20);

