package com.timbuchalka;

public class Button {

    private String title;
    private OnCLickListener onClickLister;

    public Button(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setOnClickLister(OnCLickListener onClickListener ) {
        this.onClickLister = onClickLister;
    }

    public void onClick() {
        this.onClickLister.onClick(this.title);
    }

    public interface OnCLickListener {
        public void onClick(String title);
    }
}
