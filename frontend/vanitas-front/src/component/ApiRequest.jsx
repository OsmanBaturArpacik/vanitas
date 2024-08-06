import {useState, useEffect, useContext} from 'react';
import axios from 'axios';
import {DataContext} from "../App";
import {ToastSuccess, ToastError, ToastInfo} from './ToastComponents';

const ApiRequest = () => {
    const [loading, setLoading] = useState(false);
    const { data, setData } = useContext(DataContext);
    const { newDataList, urlList } = data;

    const apiTest = async (url) => {
        if (!url) {
            return;
        }
        setLoading(true);
        let checkError = false;
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
            console.log(response.data);

            const updatedUrlList = [];
            const tempDataList = [];
            for (const fetchedUrl of fetchedUrls ) {
                try {
                    if (urlList.includes(fetchedUrl)) {
                        console.log('URL already processed:', fetchedUrl);
                        ToastInfo("URL (" + fetchedUrl + ") halihazırda tablolar içinde var.");
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
                    ToastError("URL'e (" + fetchedUrl + ") erişirken hata oluştu. Error Mesajı: " + error.message);
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
            checkError = true;
            console.error('Error fetching data:', error);
            ToastError("Veri çekme sırasında hata meydana geldi. Input:(" + url + ") Error Mesajı: " + error.message);
        } finally {
            if (!checkError) {
                ToastSuccess("İşlem başarıyla gerçekleştirildi. ( " + url + " )");
            }
            setLoading(false);
        }
    };

    useEffect(() => {
        apiTest(); // apiTest fonksiyonunu useEffect içinde çağırınca sayfa yüklendiğinde çalışır
    }, []); // Bağımlılık dizisi boş, sadece bir kere çalışır

    return { loading, apiTest};
};

export default ApiRequest;