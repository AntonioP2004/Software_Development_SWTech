const { app, BrowserWindow } = require('electron');
const path = require('path');
const url = require('url');
const fs = require('fs');

var gracefulFs = require('graceful-fs')
gracefulFs.gracefulify(fs)

let mainWindow;

const nameList = 'linksList.html';
const folderPathMain = (__dirname, 'SCP-Index');
const filePathList = path.join(folderPathMain, nameList);
listPage();
mainPage();
// create linksList.html
function listPage() {
    const htmlContentList = `
    <!DOCTYPE html>
        <html>
            <body>
                <div id="links-container">
                    <p><a href="linksList.html">links list page</a></p>
                    `;
    if (fs.existsSync(filePathList)) {
        console.log('linksList.html file exists');
        return;
    } 

    fs.writeFile(filePathList, htmlContentList, (err) => {
        if (err) console.error(err);
        else console.log('linksList.html file created successfully.');
    });

    fs.writeFile(filePathList, htmlContentList, (err) => {
        if (err) console.error(`Failed to create file linksList.html:`, err);
        else console.log(`File linksList.html created successfully.`);
    });
}


// create main.html
function mainPage() {
    const nameMain = 'main.html';
    const folderPathMain = (__dirname, 'SCP-Index');
    const filePathMainNew = path.join(folderPathMain, nameMain);
    const htmlContentMain = `
    <!DOCTYPE html>
    <html>
    <head>
        <title>SCP-Files</title>
    </head>
    <body>
        <h1>Welcome to the Main page</h1>
        <p>This app is a wiki page!</p>
        <p><a href="linksList.html">to the links!</a></p>
    </body>
    </html>`;
    const htmlLink = 
    `<p><a href="main.html">main page</a></p>
    `;
    if (fs.existsSync(filePathMainNew)) {
        console.log('main.html file exists');
    } else {
        fs.writeFile(filePathMainNew, htmlContentMain, (err) => {
            if (err) {
                console.error(err);
            } else {
                console.log('main.html file created successfully.');
            }
        });

        fs.appendFile(filePathList, htmlLink, (err) => {
            if (err) {
                console.error(err);
            } else {
                console.log('link created succesfully');
            }
        });
    }

    fs.writeFile(filePathMainNew, htmlContentMain, (err) => {
        if (err) {
            console.error(`Failed to create file main.html:`, err);
        } else {
            console.log(`File main.html created successfully.`);
        }
    });
}


// function createHTMLFiles() {
//     const folderName = 'SCP-Index';
//     const baseFileName = 'SCP-';
//     const fileExtension = '.html';
//     const startNumber = 2;
//     const endNumber = 7999;

//     // Create the folder if it doesn't exist
//     if (!fs.existsSync(folderName)) {
//         fs.mkdir(folderPath, (err) => {
//             if (err) {
//                 console.error(err);
//             } else {
//                 console.log(`Folder "${folderName}" created successfully.`);
//             }
//         });
//     }

//     //create all html files foer SCP-002 through SCP-7999
//     for (let i = startNumber; i <= endNumber; i++) {
//         const fileName = baseFileName + i.toString().padStart(3, '0') + fileExtension;
//         const filePath = path.join(folderName, fileName);
//         const outputFile = fileName.replace('.html', '');
//         const fileContent = 
//         `<!-- File: ${fileName} -->\n
//         <html>
//             <body>
//                 <h1>${fileName}</h1>
//                 <p><a href="linksList.html">links page</a></p>
//             </body>
//             <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.4/axios.min.js"></script>
//   <script src="https://cdnjs.cloudflare.com/ajax/libs/cheerio/1.0.0-rc.10/cheerio.min.js"></script>
//   <script>
//     function scrapeWikiPage() {
//       const url = 'https://scp-wiki.wikidot.com/SCP-002';

//       axios.get(url)
//         .then(response => {
//           const html = response.data;
//           const $ = cheerio.load(html);

//           const paragraphs = $('#main-content p');

//           paragraphs.each((index, element) => {
//             const paragraphText = $(element).text();
//             console.log(paragraphText);
//           });
//         })
//         .catch(error => {
//           console.error('ERROR:', error.message);
//         });
//     }

//     scrapeWikiPage();
//   </script>
//         </html>`;
//         var SCPLink = 
//         `<p><a href=" ${fileName} ">${fileName} page</a></p>
//         `

//         // Check if the file already exists
//         if (fs.existsSync(filePath)) {
//             console.log(`File ${filePath} already exists.`);
//             fs.writeFile(filePath, fileContent, (err) => {
//                 if (err) {
//                     console.error(`Failed to rewrite ${filePath}:`, err);
//                 } else {
//                     console.log(`File ${filePath} rewritten`);
//                 }
//             });
//             continue;
//         }
    
//         fs.writeFile(filePath, fileContent, (err) => {
//             if (err) {
//                 console.error(`Failed to create file ${filePath}:`, err);
//             } else {
//                 console.log(`File ${filePath} created successfully.`);
//             }
//         });
        
//         fs.appendFile(filePathList, SCPLink, (err) => {
//             if (err) {
//                 console.error(err);
//             } else {
//                 console.log('link created succesfully');
//             }
//         });
//     }
// }
// createHTMLFiles();

// function endListFile() {
//     var fileEnd = 
//         `</div>
//             <script src="main.js"></script>
//         </body>
//     </html>`
//     fs.appendFile(filePathList, fileEnd, (err) => {
//         if (err) {
//             console.error(err);
//         } else {
//             console.log('end of LinksList.html created');
//         }
//     });
// }
// endListFile();

function createWindow() {
    mainWindow = new BrowserWindow({
        width: 800,
        height: 600,
        webPreferences: {
        nodeIntegration: true
        }
    });

    mainWindow.loadURL(
        url.format({
        pathname: path.join(__dirname, 'SCP-Index\\main.html'),
        protocol: 'file:',
        slashes: true
        })
    );

    mainWindow.on('closed', () => {
        mainWindow = null;
    });
    }

    app.on('ready', createWindow);

    app.on('window-all-closed', () => {
        if (process.platform !== 'darwin') {
            app.quit();
        }
    });

    app.on('activate', () => {
    if (mainWindow === null) {
        createWindow();
    }
});