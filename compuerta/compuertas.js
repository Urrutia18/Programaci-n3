// Compuerta AND de 3 entradas
function AND3(A, B, C) {
    return A && B && C;
}

// Compuerta OR de 3 entradas
function OR3(A, B, C) {
    return A || B || C;
}

// Prueba
console.log("AND:", AND3(1,1,1)); // 1
console.log("OR:", OR3(0,0,1));  // 1