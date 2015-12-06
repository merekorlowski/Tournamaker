package com.example.merek.tournamaker;

public class Team {
    private String name;
    private String iconPath;
    private boolean isIconDrawable;

    public Team (String name){
        this.name = name;
        iconPath = null;
        isIconDrawable = false;
    }

    public Team (String name, String iconPath, boolean isIconDrawable){
        this.name = name;
        this.iconPath = iconPath;
        this.isIconDrawable = isIconDrawable;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath( String iconPath ) {
        this.iconPath = iconPath;
    }

    public boolean getIsIconDrawable() {
        return isIconDrawable;
    }

    public void setIsIconDrawable( boolean isIconDrawable ) {
        this.isIconDrawable = isIconDrawable;
    }
}
