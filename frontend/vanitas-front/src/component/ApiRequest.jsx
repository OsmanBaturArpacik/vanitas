import {useState, useEffect, useCallback, useRef, useContext} from 'react';
import axios from 'axios';
import AddCard from "./AddCard";
import {DataContext} from "../App";
const ApiRequest = () => {
    const [loading, setLoading] = useState(false);
    const { data, setData } = useContext(DataContext);
    const { newDataList, urlList } = data;

    const apiTest = async (url) => {
        setLoading(true);
        try {
            const response = await axios.post(
                'http://localhost:8080/crawler/urls',
                url,
                {
                    headers: {
                        'Content-Type': 'text/plain'
                    },
                    responseType: 'json'
                }
            );
            const fetchedUrls  = response.data;
            console.log(response.data)

            const updatedUrlList = [];
            const tempDataList = [];
            for (const fetchedUrl of fetchedUrls ) {
                try {
                    if (urlList.includes(fetchedUrl)) {
                        //TODO: toast
                        console.log('URL already processed:', fetchedUrl);
                        continue;
                    }
                    const apiResponse = await axios.post(
                        'http://localhost:8080/suggestion/normalize',
                        fetchedUrl,
                        {
                            headers: {
                                'Content-Type': 'text/plain'
                            },
                            responseType: 'json'
                        }
                    );
                    console.log('Successfully sent URL:', fetchedUrl);
                    console.log('API response:', apiResponse.data);
                    tempDataList.push(apiResponse.data);
                    updatedUrlList.push(fetchedUrl);
                } catch (error) {
                    console.error('Error sending URL:', fetchedUrl, error);
                }
            }
            // State'i güncelle
            if (tempDataList.length > 0) {
                setData(prevData => ({
                    ...prevData,
                    newDataList: [...prevData.newDataList, ...tempDataList],
                    urlList: [...prevData.urlList, ...updatedUrlList],
                }));
            }
        } catch (error) {
            console.error('Error fetching data:', error);
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        apiTest(); // apiTest fonksiyonunu useEffect içinde çağırınca sayfa yüklendiğinde çalışır
    }, []); // Bağımlılık dizisi boş, sadece bir kere çalışır

    return { loading, apiTest};
};

export default ApiRequest;