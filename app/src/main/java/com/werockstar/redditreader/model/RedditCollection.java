package com.werockstar.redditreader.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RedditCollection {

    @SerializedName("data")
    private Datas datas;

    public Datas getDatas() {
        return datas;
    }

    public void setDatas(Datas datas) {
        this.datas = datas;
    }

    public class Datas {

        @SerializedName("children")
        private List<Children> childrenList;

        public List<Children> getChildrenList() {
            return childrenList;
        }

        public void setChildrenList(List<Children> childrenList) {
            this.childrenList = childrenList;
        }

        public class Children {

            @SerializedName("data")
            private Data data;

            public Data getData() {
                return data;
            }

            public void setData(Data data) {
                this.data = data;
            }

            public class Data {

                @SerializedName("title")
                private String title;

                @SerializedName("url")
                private String url;

                @SerializedName("author")
                private String author;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getAuthor() {
                    return author;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }
            }
        }
    }
}
