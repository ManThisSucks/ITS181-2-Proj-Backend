<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Countries and Capitals</title>

    <style type="text/css">
        body {
            width:700px;
            margin:20px auto;
            font-family: sans-serif;
        }
        table {
            border-collapse: collapse;
        }

        th, td {
            border: 2px solid #07385a;
            padding: 15px;
            text-align: center;
        }

        th {
            background-color: #084975;
            color: #fff;
        }

        .country_name-cell {
            width: 200px;
            font-weight: bold;
        }

        .capital-cell {
            color: #1c1c75;
        }

        .population-cell {
            color: #1c1c75;
        }

        body{
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            font-family: 'Jost', sans-serif;
            background: linear-gradient(to bottom, #0f0c29, #302b63, #24243e);
        }

    </style>

</head>
<body>
    <h1>List of Countries and Their Capitals</h1>

    <table border="1">
        <thead>
        <tr>
            <th>Country</th>
            <th>Language</th>
            <th>Capital</th>
            <th>Capital Population</th>
            <th>Flag</th>
        </tr>
        </thead>
        <tbody>
            <#list countries as dog>
                <tr>
                    <td class="country_name-cell">${dog.name}</td>
                    <td>${dog.breed}</td>
                    <td class="capital-cell">${dog.capital.name}</td>
                    <td class="population-cell">${dog.capital.population}</td>
                    <td class="flag-cell">
                        <img src="${dog.capital.flagFilePath}" alt="${dog.name}/${dog.capital.name} Flag" width="50">
                    </td>
                </tr>
            </#list>
        </tbody>
    </table>
</body>
</html>
