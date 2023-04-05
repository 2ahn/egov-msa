const CMM = {

    parseData: (data = {}) => {

        const dto = { token: "토큰값", data: JSON.stringify(data)}

        return JSON.stringify(dto);
    },

    submitData: (url, method = '', data = {}, callbackFnc = () => {}, errorCallbackFnc = () => {}, async = true) => {

        try {

            const mtd = method !== undefined && method.length > 0 ? method : 'POST';

            $.ajax({
                type: mtd,
                url: url,
                data: CMM.parseData(data),
                dataType: 'json',
                contentType: 'application/json',
                async: async,
                success: callbackFnc,
                error: (err) => {
                    console.error(err);
                    errorCallbackFnc()
                }
            })

        } catch (e) {
            console.error(e);
        } finally {

        }
    }

}